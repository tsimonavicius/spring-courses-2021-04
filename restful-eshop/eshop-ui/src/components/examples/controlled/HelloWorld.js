import React from "react";

class HelloWorld extends React.Component {
	constructor(props) {
		super(props)
		this.state = {...props.user}
	}

	onChange = (e) => {
		console.log("Event:", e)
		console.log("Value:", e.target.value)

		this.setState({
			...this.state,
			name: e.target.value
		})
	}

	render() {
		return (
			<>
				<div>
					Hello,
					<strong>
						<span className="red">{this.state.name} {this.state.surname}</span>
					</strong>
					, from Class Component!
				</div>
				<input onChange={this.onChange} value={this.state.name}/>
			</>
		)
	}
}

export default HelloWorld;
