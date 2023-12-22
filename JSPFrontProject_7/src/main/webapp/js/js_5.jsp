<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
let sawons=[
	{sabun:1,name:"홍길동",dept:"개발부",job:"대리",pay:3500},	
	{sabun:2,name:"심청이",dept:"인사부",job:"사원",pay:2500},	
	{sabun:3,name:"강감찬",dept:"자재부",job:"과장",pay:4500},	
	{sabun:4,name:"박문수",dept:"감찰부",job:"차장",pay:5500},	
	{sabun:5,name:"이순신",dept:"영업부",job:"부장",pay:6500}	
]
// 전역변수
// main
window.onload=function(){
	sawonList()
	sawonDetail(3)
	sawonInsert()
	sawonDelete()
	sawonSlice()
}
const sawonList=function(){
	console.log(sawons)
}
const sawonDetail=(sabun)=>{
	let sawon=sawons.find(sa=>sa.sabun==sabun) 
	// ************************
	console.log(sawon)
}
function sawonInsert(){
	sawons.push({sabun:6,name:"을지문덕",dept:"영업부",job:"부장",pay:7500})
	// ********************
}
const sawonDelete=()=>{
	sawons.pop()
	// ******************
	console.log(sawons)
}
const sawonSlice=()=>{
	let sa=sawons.slice(1,3) // 인덱스순서(0,1,2...) 마지막번호 미포함
	// ********************
	console.log(sa)
	/*
		let arr=[1,2,3,4,5,6,7]
		let a=arr.slice(0,5) ==> 0 1 2 3 4
		a=[1,2,3,4,5]
	*/
}
</script>
</head>
<body>

</body>
</html>