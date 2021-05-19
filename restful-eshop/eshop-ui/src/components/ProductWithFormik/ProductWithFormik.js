import {Formik} from "formik"

export default () => (
	<Formik initialValues={{name: ''}}
			onSubmit={(values, helpers) => {
				console.log("values", values)
				console.log("helpers", helpers)

				helpers.setSubmitting(true)

				setTimeout(() => {
					helpers.setSubmitting(false)
				}, 3000)
			}}>
		{props => {
			console.log("render props", props)
			return (
				<form onSubmit={props.handleSubmit}>
					<label htmlFor="name"/>
					<input id="name" onChange={props.handleChange}/>

					{!props.isSubmitting ? <button type="submit">Submit</button> : <span>Submitting...</span>}
				</form>
			)
		}}
	</Formik>
)
