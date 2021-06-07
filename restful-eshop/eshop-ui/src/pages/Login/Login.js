import {Form, Formik} from "formik"
import FormikInput from "../../components/FormikInput/FormikInput";
import Button from "@material-ui/core/Button";
import {login} from "../../api/userApi";
import Container from "@material-ui/core/Container";
import {useDispatch} from "react-redux";
import {useHistory, useLocation} from 'react-router-dom'
import {login as setLogin} from '../../store/slices/userSlice'

const Login = () => {

	const dispatch = useDispatch()
	const history = useHistory()
	const location = useLocation()

	const postLogin = (loginData, {setSubmitting}) => {
		setSubmitting(true)

		login(loginData)
			.then(({data: loggedInUser, headers: { authorization }}) => {
				dispatch(
					setLogin({
						loggedInUser,
						jwt: authorization
					}))

				const from = location.state?.from

				history.push(from || '/')
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
