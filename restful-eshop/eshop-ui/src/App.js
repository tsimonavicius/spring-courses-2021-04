import "./style.css"
import Header from "./components/Header/Header";
import Content from "./components/Content";
import Footer from "./components/Footer";
import CssBaseline from "@material-ui/core/CssBaseline";
import React from "react";
import {makeStyles} from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
	root: {
		display: 'flex',
		flexDirection: 'column',
		minHeight: '100vh',
	}
}));

function App() {
	const classes = useStyles()

	return (
		<div className={classes.root}>
			<CssBaseline />
			<Header/>
			<Content/>
			<Footer/>
		</div>
	);
}

export default App;
