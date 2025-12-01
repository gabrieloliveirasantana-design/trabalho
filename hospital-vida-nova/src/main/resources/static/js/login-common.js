// src/main/resources/static/js/login-common.js
document.addEventListener("DOMContentLoaded", () => {

  // Abre modal com base em ids com prefixo helpBtn
  document.querySelectorAll('[id^="helpBtn"]').forEach(btn => {
    btn.addEventListener('click', () => {
      const modalId = btn.id.replace('helpBtn','helpModal');
      const modal = document.getElementById(modalId);
      if (modal) modal.style.display = 'block';
    });
  });

  // Fecha modal ao clicar no X
  document.querySelectorAll('.close').forEach(x => {
    x.addEventListener('click', () => {
      const modal = x.closest('.modal');
      if (modal) modal.style.display = 'none';
    });
  });

  // Fecha modal ao clicar fora do conteúdo
  window.addEventListener('click', (e) => {
    document.querySelectorAll('.modal').forEach(m => {
      if (e.target === m) m.style.display = 'none';
    });
  });

  // Tabs dentro do modal (troca conteúdo)
  document.querySelectorAll('.tab-btn').forEach(btn => {
    btn.addEventListener('click', () => {
      const tabId = btn.dataset.tab;
      const tabsWrapper = btn.closest('.tabs');
      // marca active no botão
      tabsWrapper.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      // alterna conteudos
      const modalContent = tabsWrapper.parentElement;
      modalContent.querySelectorAll('.tab-content').forEach(tc => tc.classList.remove('active'));
      const target = modalContent.querySelector('#' + tabId);
      if (target) target.classList.add('active');
    });
  });

});
