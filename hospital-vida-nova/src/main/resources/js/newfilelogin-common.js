document.addEventListener("DOMContentLoaded", () => {
  // modal help (aplica a todos com id helpBtn -> helpModal)
  document.querySelectorAll('[id^="helpBtn"]').forEach(btn => {
    btn.addEventListener('click', () => {
      const id = btn.id.replace('helpBtn','helpModal');
      const modal = document.getElementById(id);
      if (modal) modal.style.display = 'block';
    });
  });

  document.querySelectorAll('.close').forEach(x => {
    x.addEventListener('click', () => x.closest('.modal').style.display = 'none');
  });

  window.addEventListener('click', (e) => {
    document.querySelectorAll('.modal').forEach(m => {
      if (e.target === m) m.style.display = 'none';
    });
  });
});

