<template>
  <div>
    <div class="div-header">
      <b-table striped hover :items="itemsHeader" :fields="fieldsHeader"></b-table>
    </div>
    <div>
        <h2>Filtros</h2>
    </div>
    
    <div class="filters">
        <b-button @click="getAll()" class="btn-retirar" variant="danger">Retirar filtro</b-button>

      <div class="filter-payment">
        <b-form-select v-model="selectedPayment" :options="options" class="mb-3">
          <!-- This slot appears above the options from 'options' prop -->
          <template v-slot:first>
            <b-form-select-option :value="null" disabled>-- Selecione um filtro de pagamento --</b-form-select-option>
          </template>
        </b-form-select>
      </div>
      <div class="filter-flag">
        <b-form-select v-model="selectedFlag" :options="optionsFlag" class="mb-3">
          <!-- This slot appears above the options from 'options' prop -->
          <template v-slot:first>
            <b-form-select-option :value="null" disabled>-- Selecione um filtro de bandeira --</b-form-select-option>
          </template>
        </b-form-select>
      </div>
      <div class="filter-date">
        <span>Data inicial</span>
        <b-form-group 
          :invalid-feedback="invalidFeedback"
          :state="state"
        >
          <b-form-input  placeholder="dd/mm/yyyy" v-model="dataInicio"></b-form-input>
        </b-form-group>
        <span>Data Final</span>
        <b-form-group
          :invalid-feedback="invalidFeedback2"
          :state="state2">
          <b-form-input placeholder="dd/mm/yyyy" v-model="dataFim"></b-form-input>
        </b-form-group>
        <b-button class="btn-enviar" variant="primary" @click="enviar()">Search</b-button>
      </div>
    </div>
    <div class="div-informacoes">
      <span >Total de registros lidos: {{totalRegistros}}</span>
      <span >Vendas débito: {{totalRegistrosDebito}} com percentual de {{percentDebito}}%</span>

      <span>Vendas crédito: {{totalRegistrosCredito}} com percentual de {{percentCredito}}%</span>

      <span>Vendas prazo: {{totalRegistrosPrazo}} com percentual de {{percentPrazo}}%</span>
      

    </div>
    <div class="div-detalhe">
      <b-table striped hover :items="itemsDetalhe" :fields="fieldsDetalhe"></b-table>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import Header from "../services/headerService";
import Detalhes from "../services/DetalheService";
import Filter from "../services/Filters";
import DetalheService from '../services/DetalheService';
export default {
  name: "Home",
  components: {},
  data() {

    return {
      
      totalRegistros:0,
      totalRegistrosCredito:0,
      totalRegistrosDebito:0,
      totalRegistrosPrazo:0,
      percentCredito:0,
      percentDebito:0,
      percentPrazo:0,

      dataInicio: '',

      dataFim: '',
      selectedPayment: null,
      selectedFlag: null,
      options: [
        { value: "credito", text: "Compras à vista no crédito" },
        { value: "debito", text: "Compras à vista no débito" },
        { value: "prazo", text: "Compras à prazo" }
      ],
      optionsFlag:[],
      

      fieldsHeader: [
        "empresa",
        "dataProcessamento",
        "periodoInicial",
        "periodoFinal",
        "versaoLayout",
        "versaoRelease"
      ],
      itemsHeader: [],
      fieldsDetalhe: [
        "estabelecimento",
        "dataEvento",
        "horaEvento",
        "instituicaoFinanceira",
        "dataPrevistaPagamento",
        "parcela",
        "valorParcela",
        "valorLiquidoTransacao",
        "valorOriginalTransacao"
      ],
      itemsDetalhe: [],
      formBandeiras:[],
    };
  },
  computed:{
    state2() {
      const dia = '[0-3]\\d\\/'
      const mes = '[01]\\d\\/'
      const ano = '[12][0129]\\d{2}'
      const data = new RegExp(dia+mes+ano,'g')
     
      var m = data.test(this.dataFim)
      if(m == true){
        return true
      }else{
        return false
      }
    },
    state() {
      const dia = '[0-3]\\d\\/'
      const mes = '[01]\\d\\/'
      const ano = '[12][0129]\\d{2}'
      const data = new RegExp(dia+mes+ano,'g')
     
      var m = data.test(this.dataInicio)
      if(m == true){
        return true
      }else{
        return false
      }
    },
      invalidFeedback() {
        return this.state === false ? 'Preencha corretamente' : ''
      },
      invalidFeedback2() {
        return this.state2 === false ? 'Preencha corretamente' : ''
      },
  },
  watch: {
    selectedPayment: async function() {
      try {
        const responseDetalhe = await Filter.filterByPayment(this.selectedPayment);
        this.selectedFlag = null
        this.itemsDetalhe = [];
        this.feedTableDetalhe(responseDetalhe)
      } catch (e) {
        alert("erro ao executar filtro");
      }
    },
    selectedFlag : async function() {
      try {
        const responseDetalhe = await Filter.filterByPaymentFlag(this.selectedFlag);
        this.selectedPayment = null
        this.itemsDetalhe = [];
        console.log(responseDetalhe);
        this.feedTableDetalhe(responseDetalhe)
      } catch (e) {
        alert("erro ao executar filtro");
      }
    }
  },
  methods: {
    async getAll(){
      try{
        const res = await DetalheService.getAll()
        this.itemsDetalhe = []
        this.feedTableDetalhe(res)
      }
      catch(e){
        alert(e.message)
      }
    },
    async enviar(){
      if(this.state == true && this.state2 == true){
        const dataInicio = this.dataInicio.split("/").reverse().join('')
        const dataFim = this.dataFim.split("/").reverse().join('')
        try{
          const res = await Filter.filterByDate(dataInicio,dataFim)
          this.itemsDetalhe = []
          this.feedTableDetalhe(res)
        }
        catch(e){
          alert(e.message)
        }
      }else{
        alert("Preencha corretamente os campos de data")
      }

    },
    convertDateToString(date) {
      var dateFormat;
      dateFormat = date.getDate() + "/";
      dateFormat = dateFormat + date.getMonth() + "/";
      dateFormat = dateFormat + date.getFullYear();
      return dateFormat;
    },
    convertHouerToString(houer) {
      var dateFormat;
      dateFormat = houer.getHours() + ":";
      dateFormat = dateFormat + houer.getMinutes() + ":";
      dateFormat = dateFormat + houer.getSeconds();
      return dateFormat;
    },
    feedTableDetalhe(responseDetalhe){
      if (Object.keys(responseDetalhe).length != 0) {
        responseDetalhe.data.forEach(element => {
          var date0 = new Date();
          date0.setTime(element.dataEvento);
          var date1 = new Date();
          date1.setTime(element.dataPrevistaPagamento);
          var houer1 = new Date();
          houer1.setTime(element.horaEvento);
          const data = {
            estabelecimento: element.estabelecimento,
            dataEvento: this.convertDateToString(date0),
            horaEvento: this.convertHouerToString(houer1),
            dataPrevistaPagamento: this.convertDateToString(date1),
            instituicaoFinanceira: element.instituicaoFinanceira,
            parcela: element.parcela,
            valorParcela: element.valorParcela,
            valorLiquidoTransacao: element.valorLiquidoTransacao,
            valorOriginalTransacao: element.valorOriginalTransacao
          };
          
          var tempFlag = data.instituicaoFinanceira.trim()
          if(!this.optionsFlag.includes(tempFlag)){
            this.optionsFlag.push(tempFlag)
          }
          this.itemsDetalhe.push(data);
        });
      }
      return Object.keys(responseDetalhe).length
    },
    feedTableHeader(responseHeader){
      if (Object.keys(responseHeader).length != 0) {
        var date0 = new Date();
        date0.setTime(responseHeader.data.dataProcessamento);
        var date1 = new Date();
        date1.setTime(responseHeader.data.periodoInicial);
        var date2 = new Date();
        date2.setTime(responseHeader.data.periodoFinal);

        const data = {
          empresa: responseHeader.data.empresaAdquirinte,
          versaoLayout: responseHeader.data.versaoLayout,
          dataProcessamento: this.convertDateToString(date0),
          versaoRelease: responseHeader.data.versaoRelease,
          periodoInicial: this.convertDateToString(date1),
          periodoFinal: this.convertDateToString(date2)
        };
        this.itemsHeader.push(data);
      }
    }
  },
  async mounted() {
    try {
      const responseHeader = await Header.getHeader();
      const responseDetalhe = await Detalhes.getAll();
      const responseCreditoPayment = await Filter.filterByPayment("credito")
      const responseDebitoPayment = await Filter.filterByPayment("debito")
      const responsePrazoPayment = await Filter.filterByPayment("prazo")
      this.feedTableHeader(responseHeader);
      this.feedTableDetalhe(responseDetalhe)
      this.totalRegistros = Object.keys(responseDetalhe.data).length
      this.totalRegistrosCredito = Object.keys(responseCreditoPayment.data).length
      this.totalRegistrosDebito = Object.keys(responseDebitoPayment.data).length
      this.totalRegistrosPrazo = Object.keys(responsePrazoPayment.data).length
      this.percentCredito = this.totalRegistrosCredito/this.totalRegistros*100
      this.percentDebito = this.totalRegistrosDebito/this.totalRegistros*100
      this.percentPrazo = this.totalRegistrosPrazo/this.totalRegistros*100
    } catch (e) {
      alert(e.message);
    }
  }
};
</script>
<style lang="scss">
.div-informacoes{
  display: flex;
  justify-content: center;
  span{
    margin: 20px;
  }
}
.btn-retirar{
  height: 40px;
  margin-right: 20px;
}
.btn-enviar{
  width: 100px;
  height: 40px;
  margin-left: 20px;
}

.div-detalhe{
    padding-top: 40px;
}
.filters{
  display: flex;
  justify-content: center;
  .filter-payment{
    width: 25%;
    margin-right: 1%;
  }
  .filter-flag{
    width: 25%;
    margin-right: 1%;
  }
  .filter-date{
    display: flex;
    margin-right: 1%;
    width: 40%;
    margin-bottom: 0px;
  }
}
</style>>

