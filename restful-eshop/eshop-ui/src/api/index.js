import axios from "axios"

const HTTP = axios.create({
	baseURL: "http://localhost:8080/eshop/api"
})

export default HTTP
