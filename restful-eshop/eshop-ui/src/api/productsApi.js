import HTTP from "."

const fetchProducts = () => HTTP.get('/products')

export { fetchProducts }
