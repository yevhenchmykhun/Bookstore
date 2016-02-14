<div id="checkout-form" class="form">
    <div class="form-header">
        Checkout
    </div>
    <div class="form-input">
        <form action="<c:url value='/purchase'/>" method="post">
            <input type="text" placeholder="Name" name="name"/>
            <input type="text" placeholder="Email Address" name="email"/>
            <input type="text" placeholder="Phone" name="phone"/>
            <input type="text" placeholder="Address" name="address"/>
            <input type="text" placeholder="City" name="city"/>
            <input type="text" placeholder="Credit Card Number" name="credit-card"/>
            <input type="submit" value="Submit"/>
        </form>
    </div>
</div>
