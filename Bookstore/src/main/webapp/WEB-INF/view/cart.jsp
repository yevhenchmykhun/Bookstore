<div id="cart-exposition">
    <div id="cart-header">
        Shopping Cart
    </div>
    <div id="cart-items-and-checkout">
        <div id="cart-items">
            <c:forEach var="item" items="${cart.items}">
                <div class="cart-item">
                    <a href="<c:url value='/description'/>?id=${item.book.id}">
                    <div class="book-image">
                        <img src="<c:url value='${initParam.relativeCoversPath}${item.book.cover}'/>">
                    </div>
                    <div class="cart-item-details">
                        <div class="cart-item-header">
                                ${item.book.name}<br/>
                                ${item.book.author}
                        </div>
                        <div class="cart-item-info">
                            Language: ${item.book.language}<br/>
                            Format: ${item.book.format}<br/>
                            Publisher: ${item.book.publisher}<br/>
                        </div>
                    </div>
                    </a>
                    <div class="cart-item-quantity">
                        <form action="<c:url value='/updatequantity'/>" method="post">
                            <input type="hidden" name="bookId" value="${item.book.id}"/>
                            <input type="text" name="quantity" value="${item.quantity}"/>
                            <input type="submit" value="Update"/>
                        </form>
                        <form action="<c:url value='/deletefromcart'/>" method="post">
                            <input type="hidden" name="bookId" value="${item.book.id}"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </div>
                    <div class="cart-item-subtotal">
                            ${item.total}$
                    </div>
                </div>
            </c:forEach>
        </div>


        <div id="checkout-confirmation" class="extraction">
            <div class="extraction-header">
                Confirmation
            </div>
            <div class="extraction-details">
                <table>
                    <tr>
                        <th>Order Total:</th>
                        <td>${cart.total}$</td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <form action="<c:url value='/checkout'/>" method="post">
                                <input type="submit" value="Continue to Checkout"/>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>