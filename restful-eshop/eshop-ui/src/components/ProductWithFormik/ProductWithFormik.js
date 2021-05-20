import {ErrorMessage, Field, Form, Formik} from "formik"
import PropsState from "../PropsState/PropsState"
import * as Yup from "yup"
import {FormControl, FormHelperText, Input, InputLabel} from "@material-ui/core";

const validationSchema = Yup.object().shape({
	name: Yup.string()
		.min(2, "Reiksme turi buti ilgesne nei 2 characteriai")
		.required(),
	price: Yup.number()
		.positive()
		.required(),
	quantity: Yup.number()
		.positive()
		.required(),
	description: Yup.string()
		.max(100)
})

export default () => (
	<Formik initialValues={{
				name: '',
				price: '',
				quantity: '',
				description: ''
			}}
			onSubmit={(values, helpers) => {
				console.log("values", values)
				console.log("helpers", helpers)

				helpers.setSubmitting(true)

				setTimeout(() => {
					helpers.setSubmitting(false)
				}, 3000)
			}}
			validationSchema={validationSchema}>
		{props => (
			<>
				<PropsState {...props} />
				<Form>
					<div>
						<FormControl error={props.touched.name && !!props.errors.name}>
							<InputLabel htmlFor="name">Product name:</InputLabel>
							<Field id="name" name="name" placeholder="Type..." as={Input}/>
							<ErrorMessage name="name" component={FormHelperText}/>
						</FormControl>
					</div>

					<div>
						<label htmlFor="price">Product price:</label>
						<Field id="price" name="price" placeholder="Type..."/>
						<ErrorMessage name="price" component="span"/>
					</div>

					<div>
						<label htmlFor="quantity">Product quantity:</label>
						<Field id="quantity" name="quantity" placeholder="Type..."/>
						<ErrorMessage name="quantity" component="span"/>
					</div>

					<div>
						<label htmlFor="description">Product quantity:</label>
						<Field id="description" name="description" placeholder="Type..." component="textarea"/>
						<ErrorMessage name="description" component="span"/>
					</div>

					{!props.isSubmitting ? <button type="submit">Submit</button> : <span>Submitting...</span>}
				</Form>
			</>
		)}
	</Formik>
)
