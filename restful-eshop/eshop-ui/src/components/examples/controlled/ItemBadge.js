import React from "react";

export default ({quantity}) => {

    const getBadgeClass = () => {
        let badgeClass = "m-2 badge bg-";
        if (quantity > 2) {
            badgeClass += "success";
        } else if (quantity < 0) {
            badgeClass += "danger";
        } else {
            badgeClass += "secondary";
        }

        return badgeClass;
    }

    return (
        <div className={getBadgeClass()}>{quantity}</div>
    );
}
