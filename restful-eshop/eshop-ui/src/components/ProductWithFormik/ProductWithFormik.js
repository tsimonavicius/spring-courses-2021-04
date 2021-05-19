import {Form, Formik} from "formik"

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
		{props => (
			<Form>
				<label htmlFor="name"/>
				<input id="name" onChange={props.handleChange}/>

				{!props.isSubmitting ? <button type="submit">Submit</button> : <span>Submitting...</span>}
			</Form>
		)
		}
	</Formik>
)
