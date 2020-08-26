import Api from './Api'

const readFile = () => {
    return Api().get("")
} 

export default{
    readFile,
}