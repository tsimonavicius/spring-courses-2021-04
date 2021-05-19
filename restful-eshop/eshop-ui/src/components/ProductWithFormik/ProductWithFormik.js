import {Form, Formik, Field, ErrorMessage} from "formik"
import {TextField} from "@material-ui/core";

export default () => (
	<Formik initialValues={{name: ''}}
			onSubmit={(values, helpers) => {
				console.log("values", values)
				console.log("helpers", helpers)

				helpers.setSubmitting(true)

				setTimeout(() => {
					helpers.setSubmitting(false)
				}, 3000)
			}}
			validate={values => {
				const errors = {}

				if (values.name.length < 5) {
					errors.name = "VAi vaiva vaia"
				}

				return errors
			}}>
		{props => (
			<Form>
				<label htmlFor="name"/>
				<Field id="name" name="name" placeholder="Type..." component={TextField}/>
				<ErrorMessage name="name" component="div"/>

				{!props.isSubmitting ? <button type="submit">Submit</button> : <span>Submitting...</span>}
			</Form>
		)
		}
	</Formik>
)
