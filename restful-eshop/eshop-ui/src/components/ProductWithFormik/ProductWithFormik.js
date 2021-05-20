import {ErrorMessage, Field, Form, Formik} from "formik"
import PropsState from "../PropsState/PropsState"
import * as Yup from "yup"
import {Container, FormControl, FormHelperText, Input, InputLabel} from "@material-ui/core";
import FormikInput from "../FormikInput/FormikInput";

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
				<Container maxWidth="sm">
					<Form>
						<div>
							<FormikInput name="name" label="Product name"
										 error={props.touched.name && !!props.errors.name}/>
						</div>

						<div>
							<FormikInput name="price" label="Product price"
										 error={props.touched.price && !!props.errors.price}/>
						</div>

						<div>
							<FormikInput name="quantity" label="Product quantity"
										 error={props.touched.quantity && !!props.errors.quantity}/>
						</div>

						<div>
							<FormikInput name="description" label="Product description"
										 error={props.touched.description && !!props.errors.description}
										 multiline rows={3} />
						</div>

						{!props.isSubmitting ? <button type="submit">Submit</button> : <span>Submitting...</span>}
					</Form>
				</Container>
			</>
		)}
	</Formik>
)
