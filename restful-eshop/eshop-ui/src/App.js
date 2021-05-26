import "./style.css"
import Header from "./components/Header/Header";
import Content from "./components/Content";
import Footer from "./components/Footer";
import CssBaseline from "@material-ui/core/CssBaseline";
import React, {createContext, useState} from "react";
import {makeStyles} from "@material-ui/core/styles";
import {BrowserRouter as Router} from "react-router-dom"

const useStyles = makeStyles((theme) => ({
	root: {
		display: 'flex',
		flexDirection: 'column',
		minHeight: '100vh',
	}
}));

const CartContext = createContext(null)

function App() {
	const classes = useStyles()
	const [products, setProducts] = useState([])

	const cart = {
		products,
		addProduct: (product) => {

			const newProducts = [...products];
			const existingProduct = newProducts.find(p => p.id === product.id);

			if (existingProduct) {
				existingProduct.itemCount++
			} else {
				newProducts.push({...product, itemCount: 1})
			}

			setProducts(newProducts);
		},
		removeProduct: (id) => setProducts(products.filter((product) => product.id !== id))
	}

	return (
		<CartContext.Provider value={cart}>
			<Router>
				<div className={classes.root}>
					<CssBaseline />
					<Header/>
					<Content/>
					<Footer/>
				</div>
			</Router>
		</CartContext.Provider>
	)
}

export default App
export { CartContext }
