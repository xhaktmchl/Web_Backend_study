let targetId;

$(document).ready(function () {
    // id 가 query 인 녀석 위에서 엔터를 누르면 execSearch() 함수를 실행하라는 뜻입니다.
    $('#query').on('keypress', function (e) {
        if (e.key == 'Enter') {
            execSearch();
        }
    });
    $('#close').on('click', function () {
        $('#container').removeClass('active');
    })

    $('.nav div.nav-see').on('click', function () {
        $('div.nav-see').addClass('active');
        $('div.nav-search').removeClass('active');

        $('#see-area').show();
        $('#search-area').hide();
    })
    $('.nav div.nav-search').on('click', function () {
        $('div.nav-see').removeClass('active');
        $('div.nav-search').addClass('active');

        $('#see-area').hide();
        $('#search-area').show();
    })

    $('#see-area').show();
    $('#search-area').hide();

    showProduct();
})


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//////////////////////////////////////////////////////////////////////////////////////////
///// 여기 아래에서부터 코드를 작성합니다. ////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

function execSearch() {
    /**
     * 검색어 input id: query
     * 검색결과 목록: #search-result-box
     * 검색결과 HTML 만드는 함수: addHTML
     */
    $('#search-result-box').empty(); // 기존 검색어 지움
    // 1. 검색창의 입력값을 가져온다.
    let query = $('#query').val();
    // 2. 검색창 입력값을 검사하고, 입력하지 않았을 경우 focus.
    if(query == ' ') {
        alert("검색어를 입력하세요."); // 경고문
        $('#query').focus(); //
    }
    // 3. GET /api/search?query=${query} 요청
    // 4. for 문마다 itemDto를 꺼내서 HTML 만들고 검색결과 목록에 붙이기!
    $.ajax({
        type:"GET",
        url: `/api/search?query=${query}`,
        success: function (response){ // List<ItemDto> 로 응답 받음
            for(let i=0;i<response.length;i++){
                let itemDto = response[i];
                let tempHtml = addHTML(itemDto); // itemDto 내용을 html로 변환
                $('#search-result-box').append(tempHtml); // 변환된 html 추가
            }
        }
    })


}

function addHTML(itemDto) {
    /**
     * class="search-itemDto" 인 녀석에서
     * image, title, lprice, addProduct 활용하기
     * 참고) onclick='addProduct(${JSON.stringify(itemDto)})'
     */
    return `<div class="search-itemDto">
            <div class="search-itemDto-left">
                <img src="${itemDto.image}" alt=""> <!--상품 이미지-->
            </div>
            <div class="search-itemDto-center">
                <div>${itemDto.title}</div>  <!--상품이름 출력-->
                <div class="price">
                   ${numberWithCommas(itemDto.lprice)} <!-- 최저가 콤마 찍어서 출력-->
                    <span class="unit">원</span>
                </div>
            </div>
            <div class="search-itemDto-right">
                <img src="images/icon-save.png" alt="" onclick='addProduct(${JSON.stringify(itemDto)})'><!--addProduct에 문자열 형태로 넣어줘야 함-->
            </div>
        </div>`
}

function addProduct(itemDto) {
    /**
     * modal 뜨게 하는 법: $('#container').addClass('active');
     * data를 ajax로 전달할 때는 두 가지가 매우 중요
     * 1. contentType: "application/json",
     * 2. data: JSON.stringify(itemDto),
     */
    // 1. POST /api/products 에 관심 상품 생성 요청
    $.ajax({
        type: "POST",
        url: "/api/products",
        contentType: "application/json",
        data: JSON.stringify(itemDto), // itemDto를 문자열로 입력했지만0 인자로 받을 때 자동으로 json형으로 변환되서 다시 문자열로 변환
        success: function (response){
            //console.log("post ok");
            $('#container').addClass('active'); // 모달화면 뜨게하기
            targetId = response.id;
        }
    })
    // 2. 응답 함수에서 modal을 뜨게 하고, targetId 를 reponse.id 로 설정 (숙제로 myprice 설정하기 위함)
}

function showProduct() {
    /**
     * 관심상품 목록: #product-container
     * 검색결과 목록: #search-result-box
     * 관심상품 HTML 만드는 함수: addProductItem
     */
    // 1. GET /api/products 요청
    $.ajax({
        type: "GET",
        url: "/api/products",
        success: function (response){ // List<product> 리스트를 get해옴
            // 2. 관심상품 목록, 검색결과 목록 비우기
            console.log("get finish")
            $('#product-container').empty();
            $('#search-result-box').empty();
            // 3. for 문마다 관심 상품 HTML 만들어서 관심상품 목록에 붙이기!
            for(let i=0;i< response.length;i++){
                let product = response[i];
                let tempHtml = addProductItem(product)
                $('#product-container').append(tempHtml); // html추가
            }
        }
    })

}

function addProductItem(product) {
    // link, image, title, lprice, myprice 변수 활용하기
    // 주의: 백틱으로 리턴
return `<div class="product-card" onClick="window.location.href='${product.link}'"> <!--상품링크 수정-->
        <div class="card-header">
            <img src="${product.image}"<!--상품이미지-->
                 alt="">
        </div>
        <div class="card-body">
            <div class="title">
                ${product.title}<!--상품이름 수정-->
            </div>
            <div class="lprice">
                <span>${numberWithCommas(product.lprice)}</span>원 <!--상품최저가 수정-->
            </div>
            <div class="isgood ${product.lprice < product.myprice ? '':'none'}"> <!--상품최저가 최신화 할 때 클래스 이름 2가지로 되게 함 수정-->
                최저가
            </div>
        </div>
    </div>`;
}

function setMyprice() {
    /**
     * 숙제! myprice 값 설정하기.
     * 1. id가 myprice 인 input 태그에서 값을 가져온다.
     * 2. 만약 값을 입력하지 않았으면 alert를 띄우고 중단한다.
     * 3. PUT /api/product/${targetId} 에 data를 전달한다.
     *    주의) contentType: "application/json",
     *         data: JSON.stringify({myprice: myprice}),
     *         빠뜨리지 말 것!
     * 4. 모달을 종료한다. $('#container').removeClass('active');
     * 5, 성공적으로 등록되었음을 알리는 alert를 띄운다.
     * 6. 창을 새로고침한다. window.location.reload();
     */
}