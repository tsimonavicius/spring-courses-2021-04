
const HelloWorld = (props) => (
	<div>
		Hello,
		<strong>
			<span>{props.user.name} {props.user.surname}</span>
		</strong>
		, from Component!
	</div>
)

export default HelloWorld;
