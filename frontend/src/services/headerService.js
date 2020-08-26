import Api from './Api'

const getHeader = () => {
    return Api().get("/header")
} 

export default{
    getHeader,
}