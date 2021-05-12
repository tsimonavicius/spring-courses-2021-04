import HelloWorld from "./components/HelloWorld";
import "./style.css"
import ItemUncontrolledComponent from "./components/examples/uncontrolled/ItemUncontrolledComponent";
import Item from "./components/examples/controlled/Item";
import Items from "./components/examples/controlled/Items";

function App() {
	return (
		<div className="App container">
			{/*<h1>Hello, World!</h1>
			<HelloWorld user={{
				name: "World",
				surname: "Surname"
			}} />
			<ItemUncontrolledComponent/>*/}
			<Items/>
		</div>
	);
}

export default App;
