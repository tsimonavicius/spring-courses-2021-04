import "./style.css"
import Header from "./components/Header/Header";
import Content from "./components/Content";
import Footer from "./components/Footer";
import CssBaseline from "@material-ui/core/CssBaseline";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";
import {BrowserRouter as Router} from "react-router-dom"
import constructStore from "./store";
import {Provider} from "react-redux";

const useStyles = makeStyles((theme) => ({
	root: {
		display: 'flex',
		flexDirection: 'column',
		minHeight: '100vh',
	}
}));

const store = constructStore()

function App() {
	const classes = useStyles()

	return (
		<Provider store={store}>
			<Router>
				<div className={classes.root}>
					<CssBaseline/>
					<Header/>
					<Content/>
					<Footer/>
				</div>
			</Router>
		</Provider>
	)
}

export default App
