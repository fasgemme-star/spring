/**
 * 
 */
  const featureMap = {
    chat: { cards: 'cardsChat', visual: 'visualChat' },
    calendar: { cards: 'cardsCalendar', visual: 'visualCalendar' },
    task: { cards: 'cardsTask', visual: 'visualTask' },
    address: { cards: 'cardsAddress', visual: 'visualAddress' },
    admin: { cards: 'cardsAdmin', visual: 'visualAdmin' }
  };

  function selectFeature(key, btn) {
    // 탭 active 처리
    document.querySelectorAll('.feature-tab').forEach(t => t.classList.remove('active'));
    btn.classList.add('active');

    // 좌측 카드 전환
    Object.values(featureMap).forEach(v => {
      document.getElementById(v.cards).style.display = 'none';
      document.getElementById(v.visual).classList.remove('show');
    });
    document.getElementById(featureMap[key].cards).style.display = 'flex';
    document.getElementById(featureMap[key].visual).classList.add('show');
  }
