import { fetchProducts } from "../../api/productsApi"
import {useEffect} from "react";

const Products = () => {

	useEffect(() => {
		fetchProducts()
			.then(response => console.log("response", response))
			.catch(error => console.log("error", error))
	})

	return (
		<h1>Products</h1>
	)
}

export default Products
