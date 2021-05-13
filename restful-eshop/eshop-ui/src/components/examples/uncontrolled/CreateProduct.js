import {useRef, useState} from "react";

export default () => {

    const productTitle = useRef('');
    const productPrice = useRef(0);
    const productDescription = useRef('');
    const productCategory = useRef(null);

    const [title, setTitle] = useState('');
    const [price, setPrice] = useState(0);
    const [description, setDescription] = useState('');
    const [category, setCategory] = useState('');
    const [visible, setVisible] = useState(false);

    const onSubmitForm = (event) => {
        event.preventDefault();

        const title = productTitle.current.value;
        const price = productPrice.current.value;
        const description = productDescription.current.value;
        const category = productCategory.current.value;

        //set const to hooks
        setTitle(title);
        setPrice(price);
        setDescription(description);
        setCategory(category);
        setVisible(true);
    }

    return (
        <>
            <form className="row g-3" onSubmit={onSubmitForm}>
                <div className="col-md-6">
                    <label htmlFor="inputEmail4" className="form-label">Product title</label>
                    <input type="text" className="form-control" id="inputEmail4" ref={productTitle}/>
                </div>
                <div className="col-md-6">
                    <label htmlFor="inputPassword4" className="form-label">Price</label>
                    <input type="number" className="form-control" id="inputPassword4" ref={productPrice}/>
                </div>
                <div className="col-12">
                    <label htmlFor="inputAddress" className="form-label">Description</label>
                    <input type="text" className="form-control" id="inputAddress" ref={productDescription}/>
                </div>
                <div className="col-md-4">
                    <label htmlFor="inputState" className="form-label">Kategorija</label>
                    <select id="inputState" className="form-select" ref={productCategory}>
                        <option>Telefonai</option>
                        <option>Televizoriai</option>
                        <option>Siurbliai</option>
                    </select>
                </div>
                <div className="col-12">
                    <button type="submit" className="btn btn-primary">Create product</button>
                </div>
            </form>
            {
                visible && <div>
                    Sukurtas produktas:
                    <div>{title}</div>
                    <div>{price}</div>
                    <div>{description}</div>
                    <div>{category}</div>
                </div>
            }
        </>
    );
}
