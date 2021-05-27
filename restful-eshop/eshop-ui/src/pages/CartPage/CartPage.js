import {Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@material-ui/core";
import Container from "@material-ui/core/Container";
import {useDispatch, useSelector} from "react-redux";
import Button from "@material-ui/core/Button";
import {removeFromCart} from "../../store/slices/cartSlice";


const CartPage = () => {

	const products = useSelector(state => state.cart)
	const dispatch = useDispatch()

	const removeProduct = (id) => dispatch(removeFromCart(id))

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
							<TableCell align="right">Actions</TableCell>
						</TableRow>
					</TableHead>
					<TableBody>
						{products.length === 0 ?
							<TableRow>
								<TableCell colSpan={4} align="center">
									Cart is empty!
								</TableCell>
							</TableRow> :

							products.map((product, index) => (
								<TableRow key={index}>
									<TableCell scope="row">
										{product.name}
									</TableCell>
									<TableCell align="right">{product.itemCount}</TableCell>
									<TableCell align="right">{product.price}</TableCell>
									<TableCell align="right">{product.price}</TableCell>
									<TableCell align="right">
										<Button variant="outlined" color="primary"
												onClick={() => removeProduct(product.id)}>Remove</Button>
									</TableCell>
								</TableRow>
							))}
					</TableBody>
				</Table>
			</TableContainer>
		</Container>
	)
}

export default CartPage
