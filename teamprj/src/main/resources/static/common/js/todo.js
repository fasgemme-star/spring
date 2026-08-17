document.addEventListener('DOMContentLoaded', () => {
    // --- 1. 전체선택 체크박스 로직 ---
    const selectAllCheckbox = document.getElementById('selectAll');
    const itemCheckboxes = document.querySelectorAll('.item-checkbox');

    selectAllCheckbox.addEventListener('change', (e) => {
        const isChecked = e.target.checked;
        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = isChecked;
        });
    });

    itemCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            const allChecked = Array.from(itemCheckboxes).every(cb => cb.checked);
            const someChecked = Array.from(itemCheckboxes).some(cb => cb.checked);

            selectAllCheckbox.checked = allChecked;
            selectAllCheckbox.indeterminate = someChecked && !allChecked;
        });
    });

    let currentSelectedTodo = null;

    // --- 2. 상세 정보 패널 토글 로직 ---
    const todoItems = document.querySelectorAll('.todo-item');
    const emptyPanel = document.getElementById('detailEmptyPanel');
    const detailPanel = document.getElementById('detailPanel');

    todoItems.forEach(item => {
        item.addEventListener('click', (e) => {
            if (e.target.closest('input[type="checkbox"]') || e.target.closest('button')) {
                return;
            }

            currentSelectedTodo = item;

            // 클릭된 항목 하이라이트 표시
            todoItems.forEach(el => el.classList.remove('bg-gray-50'));
            item.classList.add('bg-gray-50');

            // dataset 속성 가져오기
            const title = item.dataset.title || '제목 없음';
            const content = item.dataset.content || '내용이 없습니다.';
            const endDate = item.dataset.endDate || '기한 없음';
            const representatives = item.dataset.representatives || '미정';
			const requester = item.dataset.requester || '알 수 없음';
            const status = item.dataset.status;

            // DOM 요소에 값 대입
            document.getElementById('detailTitle').textContent = title;
            document.getElementById('detailContent').textContent = content;
            document.getElementById('detailEndDate').textContent = endDate;
            document.getElementById('detailRepresentatives').textContent = representatives;
			document.getElementById('detailRequester').textContent = requester;

            // 상태값에 따른 텍스트 및 버튼 스타일 변경
            const detailStatusText = document.getElementById('detailStatusText');
            const detailActionBtn = document.getElementById('detailActionBtn'); // 추가된 버튼 엘리먼트

            if (status === '1') {
                // 1) 완료 상태일 때
                if (detailStatusText) detailStatusText.textContent = '완료된 할 일';
                if (detailActionBtn) {
                    detailActionBtn.textContent = '미완료로 변경';
                    // 회색 버튼으로 클래스 변경
                    detailActionBtn.className = 'w-full bg-gray-400 hover:bg-gray-500 text-white font-bold py-3.5 rounded-lg mb-8 transition shadow-sm';
                }
            } else {
                // 2) 미완료 상태일 때
                if (detailStatusText) detailStatusText.textContent = '미완료된 할 일';
                if (detailActionBtn) {
                    detailActionBtn.textContent = '완료하기';
                    // 파란색 버튼으로 클래스 복구
                    detailActionBtn.className = 'w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-3.5 rounded-lg mb-8 transition shadow-sm';
                }
            }

            // 빈 화면 숨기고 상세 패널 표시
            emptyPanel.classList.remove('flex');
            emptyPanel.classList.add('hidden');

            detailPanel.classList.remove('hidden');
            detailPanel.classList.add('flex');
        });
    });


    // --- 4. 모달창 열기/닫기 로직 ---
    const todoModal = document.getElementById('todoModal');
    const openTodoModalBtn = document.getElementById('openTodoModalBtn');
    const editTodoBtn = document.getElementById('editTodoBtn');
    const closeTodoModalBtn = document.getElementById('closeTodoModalBtn');
    const cancelTodoModalBtn = document.getElementById('cancelTodoModalBtn');
    const modalTitleInput = document.getElementById('modalTitleInput');
    const modalContentInput = document.getElementById('modalContentInput');
    // 모달 열기
    if (openTodoModalBtn) {
        openTodoModalBtn.addEventListener('click', () => {
            // 새 글을 작성하는 것이므로 입력창 초기화
            if (modalTitleInput) modalTitleInput.value = '';
            if (modalContentInput) modalContentInput.value = '';

            todoModal.classList.remove('hidden');
        });
    }

    if (editTodoBtn) {
        editTodoBtn.addEventListener('click', () => {
            if (!currentSelectedTodo) return; // 선택된 할 일이 없으면 종료

            // 현재 선택된 아이템의 데이터 가져오기
            const title = currentSelectedTodo.dataset.title || '';
            const content = currentSelectedTodo.dataset.content || '';

            // 모달창에 기존 데이터 채워넣기
            if (modalTitleInput) modalTitleInput.value = title;
            if (modalContentInput) modalContentInput.value = content;

            // 모달 열기
            todoModal.classList.remove('hidden');
        });
    }

    // 모달 닫기 함수
    const closeModal = () => {
        todoModal.classList.add('hidden');
    };

    // X 버튼과 취소 버튼에 닫기 이벤트 연결
    if (closeTodoModalBtn) closeTodoModalBtn.addEventListener('click', closeModal);
    if (cancelTodoModalBtn) cancelTodoModalBtn.addEventListener('click', closeModal);

    // 모달 바깥 영역(검은 배경) 클릭 시 닫기
    todoModal.addEventListener('click', (e) => {
        if (e.target === todoModal) {
            closeModal();
        }
    });

    // --- 5. 기한(날짜) 선택 로직 ---
    const todoEndDateInput = document.getElementById('todoEndDate'); // 서버로 넘어갈 hidden input
    const customDateInput = document.getElementById('customDateInput'); // 달력 input
    const dateBtns = document.querySelectorAll('.date-btn');

    // 날짜를 YYYY-MM-DD 형식의 문자열로 변환하는 함수
    const formatDate = (date) => {
        if (!date) return '';
        const y = date.getFullYear();
        const m = String(date.getMonth() + 1).padStart(2, '0');
        const d = String(date.getDate()).padStart(2, '0');
        return `${y}-${m}-${d}`;
    };

    // 버튼 활성화 스타일 변경 함수
    const setActiveDateButton = (activeBtn) => {
        dateBtns.forEach(btn => {
            // 모든 버튼을 기본(비활성) 상태로 변경
            btn.classList.remove('bg-blue-600', 'text-white', 'font-medium');
            btn.classList.add('bg-white', 'text-gray-600');
        });

        // 클릭된 버튼만 활성화 상태로 변경
        if (activeBtn) {
            activeBtn.classList.remove('bg-white', 'text-gray-600');
            activeBtn.classList.add('bg-blue-600', 'text-white', 'font-medium');
        }
    };

    // 1) 기한 빠른 선택 버튼 클릭 이벤트
    dateBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            setActiveDateButton(btn); // 스타일 활성화

            const dateType = btn.dataset.dateType;
            let targetDate = new Date(); // 기본값: 오늘

            if (dateType === 'none') {
                todoEndDateInput.value = '';
                customDateInput.value = '';
                return;
            } else if (dateType === 'today') {
                // targetDate는 이미 오늘 날짜
            } else if (dateType === 'tomorrow') {
                targetDate.setDate(targetDate.getDate() + 1);
            } else if (dateType === 'nextWeek') {
                targetDate.setDate(targetDate.getDate() + 7);
            }

            const formattedDate = formatDate(targetDate);
            todoEndDateInput.value = formattedDate; // 폼 전송용 값 세팅
            customDateInput.value = formattedDate; // 달력 UI 동기화
        });
    });

    // 2) 달력(input type="date")에서 사용자가 직접 날짜를 선택했을 때 이벤트
    if (customDateInput) {
        customDateInput.addEventListener('change', (e) => {
            // 선택한 날짜를 폼 전송용 input에 세팅
            todoEndDateInput.value = e.target.value;
            // 직접 날짜를 선택했으므로 모든 빠른 버튼의 활성화 스타일 제거
            setActiveDateButton(null);
        });
    }


});

// 팝업 띄우는 함수
function openAddressPopup(url) {
    const title = "AddressBookPopup";
    const specs = "width=850,height=600,left=200,top=100,scrollbars=yes,resizable=yes";

    // 팝업 호출
    window.open(url, title, specs);
}

window.addRepresentative = function(empName, empId) {
    const container = document.getElementById('repListContainer');

    // 이미 추가된 사원인지 중복 확인 (선택 사항)
    const existing = container.querySelector(`input[value="${empId}"]`);
    if (existing) {
        alert("이미 추가된 담당자입니다.");
        return;
    }

    // 담당자 뱃지(Span) 생성
    const span = document.createElement('span');
    span.className = "inline-flex items-center gap-1.5 px-3 py-1 bg-gray-100 text-gray-600 rounded-md text-[13px] font-medium";

    // X 버튼 클릭 시 해당 태그 삭제 기능 포함
    // 폼 전송을 위해 hidden input으로 사번(empId) 추가
    span.innerHTML = `
        ${empName} 
        <button type="button" class="hover:text-gray-800" onclick="this.closest('span').remove();">
            <i class="fa-solid fa-xmark text-[10px]"></i>
        </button>
        <input type="hidden" name="representUserNo" value="${empId}">
    `;

    // 컨테이너에 뱃지 추가
    container.appendChild(span);
};