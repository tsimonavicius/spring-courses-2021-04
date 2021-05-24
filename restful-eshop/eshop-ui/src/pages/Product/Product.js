import { useParams } from "react-router-dom"

const Product = () => {
	const { productId } = useParams()

	return (
		<h1>{productId}</h1>
	)
}

export default Product
