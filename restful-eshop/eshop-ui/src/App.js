import "./style.css"
import Header from "./components/Header/Header";
import Content from "./components/Content";
import Footer from "./components/Footer";
import CssBaseline from "@material-ui/core/CssBaseline";
import React from "react";

function App() {
	return (
		<div className="App container">
			<CssBaseline />
			<Header/>
			<Content/>
			<Footer/>
		</div>
	);
}

export default App;
