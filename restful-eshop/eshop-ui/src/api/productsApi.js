import HTTP from "."

const fetchProducts = () => HTTP.get('/products')
	.finally(response =>
		new Promise((resolve, reject) => {
			setTimeout(() => resolve(response), 5000)
		})
	)

export { fetchProducts }
