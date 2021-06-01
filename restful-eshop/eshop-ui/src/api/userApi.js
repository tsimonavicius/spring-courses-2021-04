import HTTP from "./index";

const login = (loginData) => HTTP.post('/login', loginData)

export { login }
