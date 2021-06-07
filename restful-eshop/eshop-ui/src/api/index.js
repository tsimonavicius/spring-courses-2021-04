import axios from "axios"
import store from '../store'

const HTTP = axios.create({
	baseURL: "/eshop/api"
})

HTTP.interceptors.request.use(config => {

	if (store.getState().user.jwt) {
		config.headers.authorization = "Bearer " + store.getState().user.jwt
	}

	return config
})

export default HTTP
