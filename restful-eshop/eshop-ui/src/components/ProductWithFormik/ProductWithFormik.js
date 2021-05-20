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
							<InputLabel htmlFor="name">Product name</InputLabel>
							<Field id="name" name="name" placeholder="Type..." as={Input}/>
							<ErrorMessage name="name" component={FormHelperText}/>
						</FormControl>
					</div>

					<div>
						<FormControl error={props.touched.price && !!props.errors.price}>
							<InputLabel htmlFor="price">Product price</InputLabel>
							<Field id="price" name="price" placeholder="Type..." as={Input}/>
							<ErrorMessage name="price" component={FormHelperText} />
						</FormControl>
					</div>

					<div>
						<FormControl error={props.touched.quantity && !!props.errors.quantity}>
							<InputLabel htmlFor="quantity">Product quantity</InputLabel>
							<Field id="quantity" name="quantity" placeholder="Type..." as={Input}/>
							<ErrorMessage name="quantity" component={FormHelperText} />
						</FormControl>
					</div>

					<div>
						<FormControl error={props.touched.description && !!props.errors.description}>
							<InputLabel htmlFor="price">Product description</InputLabel>
							<Field id="description" name="description" placeholder="Type..."
								   multiline rows={3} as={Input}/>
							<ErrorMessage name="description" component={FormHelperText} />
						</FormControl>
					</div>

					{!props.isSubmitting ? <button type="submit">Submit</button> : <span>Submitting...</span>}
				</Form>
			</>
		)}
	</Formik>
)
