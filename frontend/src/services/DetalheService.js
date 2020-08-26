import Api from './Api'

const getOne = () => {
    return Api().get("/header")
} 
const getAll = () => {
    return Api().get("/detalhes/all")
} 

export default{
    getOne,
    getAll
}