import HelloWorld from "./components/HelloWorld";
import "./style.css"
import ItemUncontrolledComponent from "./components/examples/uncontrolled/ItemUncontrolledComponent";

function App() {
	return (
		<div className="App">
			<h1>Hello, World!</h1>
			<HelloWorld user={{
				name: "World",
				surname: "Surname"
			}} />
			<ItemUncontrolledComponent/>
		</div>
	);
}

export default App;
