    // 별 아이콘(즐겨찾기) 토글
    function toggleStar(element) {
        const icon = element.querySelector('i');
        if (icon.classList.contains('fa-regular')) {
            icon.classList.remove('fa-regular', 'text-gray-300');
            icon.classList.add('fa-solid', 'text-yellow-400');
        } else {
            icon.classList.remove('fa-solid', 'text-yellow-400');
            icon.classList.add('fa-regular', 'text-gray-300');
        }
    }

    // 로우 선택 및 우측 상세 패널 열기
    function selectRow(row, event) {
        // 다른 로우의 선택 상태 제거
        document.querySelectorAll('.contact-row').forEach(r => {
            r.classList.remove('table-row-selected');
        });
        // 현재 로우 선택 상태 추가
        row.classList.add('table-row-selected');

        // 숨겨진 Input 데이터 가져오기
        const initial = row.querySelector('.data-initial').value;
        let color = row.querySelector('.data-color').value;
        const name = row.querySelector('.data-name').value;
        let title = row.querySelector('.data-title').value;
        const org = row.querySelector('.data-org').value;
        const dept = row.querySelector('.data-dept').value;
        const email = row.querySelector('.data-email').value;

        // 데이터 포맷팅 보정 (빈값 처리)
        if(!title || title.trim() === '') title = '직급 없음';

        // 우측 패널에 데이터 세팅
        const avatarElem = document.getElementById('panelAvatar');
        avatarElem.className = `w-20 h-20 rounded-full text-white flex items-center justify-center font-medium text-3xl shrink-0 ${color}`;
        avatarElem.innerText = initial;
        
        document.getElementById('panelName').innerText = name;
        document.getElementById('panelTitle').innerText = title;
        document.getElementById('panelOrg').innerText = org;
        document.getElementById('panelDept').innerText = dept;
        
        // 부서가 없으면 텍스트 숨김 처리
        const deptTitleWrapper = document.getElementById('panelDeptTitle');
        if(dept && dept.trim() !== '') {
            deptTitleWrapper.style.display = 'block';
        } else {
            deptTitleWrapper.style.display = 'none';
        }

        document.getElementById('panelEmail').innerText = email;
        document.getElementById('panelEmail').href = `mailto:${email}`;

        // 패널 열기 애니메이션
        const panel = document.getElementById('detailPanel');
        panel.classList.remove('translate-x-full');
    }

    // 우측 상세 패널 닫기
    function closePanel() {
        const panel = document.getElementById('detailPanel');
        panel.classList.add('translate-x-full');
        
        // 로우 선택 상태 해제
        document.querySelectorAll('.contact-row').forEach(r => {
            r.classList.remove('table-row-selected');
        });
    }
	function toggleMenu(element) {
	        // 클릭한 버튼의 바로 다음 요소(하위 div)를 찾습니다.
	        const childMenu = element.nextElementSibling;
	        // 클릭한 버튼 내부의 화살표 아이콘을 찾습니다.
	        const icon = element.querySelector('.fa-caret-down');

	        if (childMenu) {
	            // 하위 div에 Tailwind의 'hidden' 클래스를 토글하여 숨기거나 보여줍니다.
	            childMenu.classList.toggle('hidden');
	        }
	        
	        if (icon) {
	            // 화살표 아이콘을 -90도 회전(오른쪽 방향)시키는 클래스를 토글합니다.
	            icon.classList.toggle('-rotate-90');
	        }
	    }
