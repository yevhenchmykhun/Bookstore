<div id="book-exposition">
    <div id="book-description">
        <div class="book-image">
            <img src="<c:url value='${initParam.relativeCoversPath}${book.cover}'/>">
        </div>
        <div id="description">
            Format: ${book.format}<br/>
            Language: ${book.language}<br/>
            ISBN: ${book.isbn}<br/>
            Release Date: ${book.releaseDate}<br/>
            Publisher: ${book.publisher}<br/>
            Length: ${book.pages}<br/>
        </div>
    </div>
    <div id="details">
        <div id="details-header">
            ${book.name} by ${book.author}.
        </div>
        <div id="overview">
            ${book.description}
        </div>
        <div>
            <form>
                Price: ${book.price}$
                <input type="hidden" value="${book.id}" name="id"/>
                <input type="submit" value="Add to Cart"/>
            </form>
        </div>
    </div>
</div>