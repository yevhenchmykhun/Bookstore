<div id="leave-page">
    <p id="leave-message">
        Your order has been successfully processed and will be delivered within short time.<br/>
        Thank you for shopping at the Bookstore.com<br/>
        Bitch.
    </p>
    <div id="extraction-block">
        <div id="order-summary" class="extraction">
            <div class="extraction-header">
                Order Summary
            </div>
            <div class="extraction-details">
                <table>
                    <tr>
                        <th id="book-name">Book</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    <c:forEach var="item" items="${cart.items}">
                        <tr>
                            <td>${item.book.name}</td>
                            <td>${item.quantity}</td>
                            <td>${item.total}$</td>
                        </tr>
                    </c:forEach>
                    <tr id="total">
                        <td></td>
                        <td>Total:</td>
                        <td>${cart.total}$</td>
                    </tr>

                    <tr id="date-processed">
                        <td>Date Processed</td>
                        <td>2016 01 20</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="delivery-address" class="extraction">
            <div class="extraction-header">
                Delivery Address
            </div>
            <div class="extraction-details">
                <div id="address">
                    ${address}, ${city}
                </div>
                <table>
                    <tr>
                        <th>Email:</th>
                        <td>${email}</td>
                    </tr>
                    <tr>
                        <th>Phone:</th>
                        <td>${phone}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
