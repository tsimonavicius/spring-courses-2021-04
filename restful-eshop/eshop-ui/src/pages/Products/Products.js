import {fetchProducts} from "../../api/productsApi"
import {useContext, useEffect, useState} from "react";
import {
    CircularProgress,
    Paper,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@material-ui/core";
import {makeStyles} from "@material-ui/styles";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import {connect} from "react-redux";
import {addToCart} from "../../store/slices/cartSlice";
import {useTranslation} from "react-i18next";

const useStyle = makeStyles((theme) => ({
    table: {
        minWidth: 650,
    },

    button: {
        background: theme.palette.primary.main,
        border: 0,
        fontSize: 15,
        color: 'white',
        borderRadius: 5,
        height: 35,
        padding: '0 30px',
        '&:hover': {
            background: theme.palette.secondary.main
        }
    }
}));

// props = { addToCart: addToCart }
// tunedAddToCart = (product) => dispatch(addToCart(product))
const Products = ({tunedAddToCart}) => {

    const {t} = useTranslation('products');
    const [products, setProducts] = useState([])
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        // componentDidMount && componentDidUpdate
        fetchProducts()
            .then(({data}) => {
                setProducts(data)
            }).finally(() => setLoading(false))
    }, [])

    const classes = useStyle()

    const handleOnClick = (product) => {
        tunedAddToCart(product)
    }

    return (
        <Container maxWidth="md">
            <TableContainer component={Paper} className={classes.table}>
                <Table aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>{t('Product Name')}</TableCell>
                            <TableCell align="right">{t('Quantity')}</TableCell>
                            <TableCell align="right">{t('Price (Eur)')}</TableCell>
                            <TableCell align="right">{t('Description')}</TableCell>
                            <TableCell align="right">{t('Actions')}</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {loading ?
                            <TableRow>
                                <TableCell colSpan={5} align="center">
                                    <CircularProgress/>
                                </TableCell>
                            </TableRow> :
                            products.map(product => (
                                <TableRow key={product.id}>
                                    <TableCell component="th" scope="row">
                                        {product.name}
                                    </TableCell>
                                    <TableCell align="right">{product.quantity}</TableCell>
                                    <TableCell align="right">{product.price}</TableCell>
                                    <TableCell align="right">{product.description}</TableCell>
                                    <TableCell align="right">
                                        <Button variant="outlined" className={classes.button}
                                                onClick={() => handleOnClick(product)}>Buy</Button>
                                    </TableCell>
                                </TableRow>
                            ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Container>
    )
}

const mapDispatchToProps = {
    tunedAddToCart: addToCart
}

// connect(null, mapDispatchToProps) -> configFn(Component) -> building props... -> Component(props)

const storeBindingFn = connect(null, mapDispatchToProps)
const ProductsWithStore = storeBindingFn(Products)

export default ProductsWithStore
