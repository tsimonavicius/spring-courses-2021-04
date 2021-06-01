import {Form, Formik} from "formik"
import FormikInput from "../../components/FormikInput/FormikInput";
import Button from "@material-ui/core/Button";
import {login} from "../../api/userApi";
import Container from "@material-ui/core/Container";

const Login = () => {

	const postLogin = (loginData, {setSubmitting}) => {
		setSubmitting(true)

		login(loginData)
			.then(({headers: {authorization}}) => {
				console.log("JWT", authorization)
			})
			.finally(() => setSubmitting(false))
	}

	return (
		<Formik
			initialValues={{
				username: '',
				password: ''
			}}
			onSubmit={postLogin}
		>
			{(props) => (
				<>
					<Container maxWidth="sm">
						<Form>
							<div>
								<FormikInput name="username"
											 label="Username"/>
							</div>
							<div>
								<FormikInput name="password"
											 label="Password"
											 type="password"/>
							</div>

							<Button variant="contained"
									fullWidth
									color="primary"
									type="submit"
									disabled={props.isSubmitting}>Submit</Button>
						</Form>
					</Container>
				</>
			)}
		</Formik>
	)
}

export default Login
