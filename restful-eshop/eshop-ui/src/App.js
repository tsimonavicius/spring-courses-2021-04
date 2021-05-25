import "./style.css"
import Header from "./components/Header/Header";
import Content from "./components/Content";
import Footer from "./components/Footer";
import CssBaseline from "@material-ui/core/CssBaseline";
import React, {createContext} from "react";
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
const cart = [{
	"id": "acf49189-e872-48b0-949e-63d455f4fd86",
	"name": "iPhone XM",
	"quantity": 200,
	"price": 1599.99,
	"description": "Naujausias iPhone!"
}]

function App() {
	const classes = useStyles()

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
