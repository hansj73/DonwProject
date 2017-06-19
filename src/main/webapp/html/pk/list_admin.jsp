<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
	<meta charset="UTF-8">
		<meta name="Generator" content="EditPlus®">
		<meta name="Author" content="">
		<meta name="Keywords" content="">
		<meta name="Description" content="">
		<title>Document</title>
		<link href="/css/ssc/layout.css" type="text/css" rel="stylesheet"  />
	</head>
	<body>
		<div id="pychang">
			<div id="header" class="header">
				<div class="top">
					<div class="topMeun">
						<div class="user">		
							<div class="userL">
								<a href="#">홍길동(gildonghong) </a>
								<a href="#"> 로그아웃</a>
							</div>				
						</div>
					</div>
				</div>
				<div class="top_visual">
				</div>
			</div>

			<div id="wrap">
				<p class="dwon_tit">올림픽 영상 다운로드 관리 </p>
				<p class="search_result">총 500 건</p>
				<form name="boardActionFrm" id="boardActionFrm" method="GET" action="">
					<input type="hidden" value="1" name="">
					<input type="hidden" value="" name="">
					<input type="hidden" value="" name="">
					<fieldset class="search">
						<legend>예약신청</legend>
						<select name="searchField" title="제목+내용">
							<option value="title">제목+내용</option>
						</select>
						<label for="searchText" class="hide">검색어 입력</label>
						<input type="text" class="it " id="searchText" value="" name="searchText" title="검색어를 입력 하세요"> 
						<a href="#" class="btn_search" onclick="">검색</a>
					</fieldset> 
				</form>
			
				<div class="boardArea ">
					<table cellpadding="0" cellspacing="0" class="tbC" summary="올림픽 영상 다운로드 관리">
						<caption>올림픽 영상 다운로드 관리</caption>
						<colgroup>
							<col width="5%">
							<col width="18%">
							<col width="*%">
							<col width="18%">
							<col width="18%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" id="" name="" title="전체선택" class=""></th>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">등록일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>10</td>
								<td class="txt1"><a href="detail.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>9</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>8</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>7</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>6</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>5</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>4</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>3</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>2</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>	
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
							<tr>
								<td><input type="checkbox" id="" name="" title="선택" class=""></td>
								<td>1</td>
								<td class="txt1"><a href="detail_admin.html">강릉 올림픽 파크 신설 경기장</a></td>
								<td>관리자</td>
								<td>2015-05-14</td>
								
							</tr>
						</tbody>
					</table>
				</div>

				<div class="paging">
					<span>
						
						<img src="/images/igm/btn_first.png" alt="처음" class="prev"></a>
						
						<img src="/images/igm/btn_prev.png" alt="이전 10페이지 이동"></a>
					</span>
					<span class="num">
						<a href="#" class="on">1</a>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#">4</a>
						<a href="#">5</a>
						<a href="#">6</a>
						<a href="#">7</a>
						<a href="#">8</a>
						<a href="#">9</a>
						<a href="#">10</a>
					</span>
					<span>
					
						<img src="/images/igm/btn_next.png" alt="다음 10페이지 이동"></a>
						
						<img src="/images/igm/btn_last.png" alt="끝" class="next"></a>
					</span>
				</div>
			
				<div class="btn_area ">
					<a href="list.html" class="del" title="삭제">삭제</a>
					<a href="list.html" class="write" title="등록">등록</a>
				</div>
			</div>
			

			<!-- div class="footer">
			</div -->
		</div>
	</body>
</html>
