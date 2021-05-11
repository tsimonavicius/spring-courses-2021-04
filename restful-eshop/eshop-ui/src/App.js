import HelloWorld from "./components/HelloWorld";
import "./style.css"

function App() {
	return (
		<div className="App">
			<h1>Hello, World!</h1>
			<HelloWorld user={{
				name: "World",
				surname: "Surname"
			}} />
		</div>
	);
}

export default App;
