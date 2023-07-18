/* @charset "UTF-8"; */

@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

html > body {
	font-family: 'GmarketSansMedium', sans-serif;
	text-underline-position:under;
}

.table-box-type-1 > table {
	width: 100%;
}

.table-box-type-1 > table th, .table-box-type-1 > table td {
	border:1px solid black;
	padding: 10px;
	text-align: center;
}

.btn-text-link {
	color:black;
}

.btn-text-link:hover {
	color:red;
	text-decoration: underline;
}

.border-bottom-line {
	border-bottom : 1px solid #d1c7c7;
}

.modal-exam {
	font-size: 2rem;
}

.layer-bg, .layer {
	display: none;
}

.layer-bg {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: rgba(0, 0, 0, .4);
}

.layer {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translateX(-50%) translateY(-50%);
	background-color: black;
	color: white;
	width: 500px;
	height: 500px;
	border: 5px solid red;
}

.layer > h1 {
	font-size: 1.5rem;
	padding: 20px;
}

.layer > div {
	margin: 20px;
}

.layer > button {
	position: absolute;
	bottom: 20px;
	right: 20px;
}

.layer > .close-x-btn {
	position: absolute;
	right: 20px;
	font-size: 4rem;
	top: -5px;
	cursor: pointer;
}








