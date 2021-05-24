import {fetchProducts} from "../../api/productsApi"
import {useEffect, useState} from "react";
import {
	CircularProgress,
	Paper,
	Table,
	TableBody,
	TableCell,
	TableContainer,
	TableHead,
	TableRow
} from "@material-ui/core";
import {makeStyles} from "@material-ui/styles";
import Container from "@material-ui/core/Container";

const useStyle = makeStyles({
	table: {
		minWidth: 650,
	}
})

const Products = () => {

	const [products, setProducts] = useState([])
	const [loading, setLoading] = useState(true)

	useEffect(() => {
		// componentDidMount && componentDidUpdate
		fetchProducts()
			.then(({data}) => {
				setProducts(data)
			}).finally(() => setLoading(false))
	}, [])

	const classes = useStyle()

	return (
		<Container maxWidth="md">
			<TableContainer component={Paper} className={classes.table}>
				<Table aria-label="simple table">
					<TableHead>
						<TableRow>
							<TableCell>Product Name</TableCell>
							<TableCell align="right">Quantity</TableCell>
							<TableCell align="right">Price (Eur)</TableCell>
							<TableCell align="right">Description</TableCell>
						</TableRow>
					</TableHead>
					<TableBody>
						{loading ?
							<TableRow>
								<TableCell colSpan={4} align="center">
									<CircularProgress/>
								</TableCell>
							</TableRow> :
							products.map(product => (
								<TableRow key={product.id}>
									<TableCell component="th" scope="row">
										{product.name}
									</TableCell>
									<TableCell align="right">{product.quantity}</TableCell>
									<TableCell align="right">{product.price}</TableCell>
									<TableCell align="right">{product.description}</TableCell>
								</TableRow>
							))}
					</TableBody>
				</Table>
			</TableContainer>
		</Container>
	)
}

export default Products
