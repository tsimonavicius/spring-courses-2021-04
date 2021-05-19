import "./style.css"
import Header from "./components/Header/Header";
import Content from "./components/Content";
import Footer from "./components/Footer/Footer";

function App() {
	return (
		<div className="App container">
			<Header/>
			<Content/>
			<Footer/>
		</div>
	);
}

export default App;
