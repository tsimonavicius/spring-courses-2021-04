import {useContext} from "react";
import {CartContext} from "../../App";
import {Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@material-ui/core";
import Container from "@material-ui/core/Container";

const CartPage = () => {

	const { products, removeProduct } = useContext(CartContext)

	return (
		<Container maxWidth="md">
			<TableContainer component={Paper}>
				<Table aria-label="simple table">
					<TableHead>
						<TableRow>
							<TableCell>Product Name</TableCell>
							<TableCell align="right">How many?</TableCell>
							<TableCell align="right">Unit Price (Eur)</TableCell>
							<TableCell align="right">Total Price (Eur)</TableCell>
						</TableRow>
					</TableHead>
					<TableBody>
						{products.length === 0 ?
							<TableRow>
								<TableCell colSpan={4} align="center">
									Cart is empty!
								</TableCell>
							</TableRow> :

							products.map(product => (
								<TableRow key={product.id}>
									<TableCell scope="row">
										{product.name}
									</TableCell>
									<TableCell align="right">{product.itemCount}</TableCell>
									<TableCell align="right">{product.price}</TableCell>
									<TableCell align="right">{product.price * 1}</TableCell>
								</TableRow>
							))}
					</TableBody>
				</Table>
			</TableContainer>
		</Container>
	)
}

export default CartPage
