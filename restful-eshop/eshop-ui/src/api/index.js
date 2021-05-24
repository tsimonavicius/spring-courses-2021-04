import axios from "axios"

const HTTP = axios.create({
	baseURL: "/eshop/api"
})

export default HTTP
