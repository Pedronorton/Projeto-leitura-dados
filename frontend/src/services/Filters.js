import Api from './Api'

const filterByPayment = (pagamento) => {
    return Api().get("/detalhes/parcelas/?tipoPagamento="+pagamento)
} 

const filterByPaymentFlag = (flag) => {
    return Api().get("/detalhes/"+flag)
} 

const filterByDate = (dataInicio, dataFim) => {
    const formData = new FormData()
    formData.append('dataInicio', dataInicio)
    formData.append('dataFim', dataFim)


    return Api().get("/detalhes/data?dataInicio="+dataInicio+"&dataFim="+dataFim)
} 

export default{
    filterByPayment,
    filterByPaymentFlag,
    filterByDate,
}