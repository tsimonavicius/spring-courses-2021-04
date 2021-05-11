
const HelloWorld = (props) => (
	<div>
		Hello,
		<strong>
			<span>{props.name} {props.surname}</span>
		</strong>
		, from Component!
	</div>
)

export default HelloWorld;
