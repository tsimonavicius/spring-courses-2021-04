import { fetchProducts } from "../../api/productsApi"
import {useEffect, useState} from "react";

const Products = () => {

	const [products, setProducts] = useState([])

	useEffect(() => {
		// componentDidMount && componentDidUpdate
		fetchProducts()
			.then(({ data }) => {
				setProducts(data)
			})
	}, [])

	return (
		<h1>
			<pre>
				{JSON.stringify(products, null, 2)}
			</pre>
		</h1>
	)
}

export default Products
