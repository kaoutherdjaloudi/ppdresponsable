const ordersTable = document.getElementById('orders-table');
const confirmedTable = document.getElementById('confirmed-table');
const modalBody = document.getElementById('modal-body');

// Récupérer les commandes dynamiquement depuis l'API
fetch('http://localhost:8080/myproject/orders')
  .then(response => response.json())
  .then(data => {
    data.forEach(order => {
      const row = createRow(order, true);
      ordersTable.appendChild(row);
    });
  })
  .catch(error => console.error('Erreur lors de la récupération des commandes:', error));

// Création d'une ligne pour la table des commandes en attente ou confirmées
function createRow(order, isPending) {
  const row = document.createElement('tr');
  row.innerHTML = `
    <td>${order.id}</td>
    <td>${order.nom}</td>
    <td>${order.telephone}</td>
    <td>${order.adresse}</td>
    <td><button class="btn btn-info btn-sm view-products" data-bs-toggle="modal" data-bs-target="#articlesModal">Voir Articles</button></td>
    <td>${calculatePrixArticles(order.articles)} DA</td>
    <td>${order.livraison} DA</td>
    <td>${order.total} DA</td>
    ${isPending ? `
      <td>
        <select class="form-select">
          <option>Pas de note</option>
          <option>Le client ne répond pas</option>
          <option>Reporté</option>
          <option>Autre</option>
        </select>
      </td>
      <td>
        <button class="btn btn-success btn-sm confirm">Confirmer</button>
        <button class="btn btn-danger btn-sm cancel">Annuler</button>
      </td>` : ""}
  `;

  // Ajouter les événements
  row.querySelector('.view-products').addEventListener('click', () => showProducts(order.articles));
  if (isPending) {
    row.querySelector('.confirm').addEventListener('click', () => confirmOrder(order, row));
    row.querySelector('.cancel').addEventListener('click', () => cancelOrder(row));
  }

  return row;
}

// Calculer le prix total des articles
function calculatePrixArticles(articles) {
  return articles.reduce((sum, article) => sum + article.prix, 0);
}

// Afficher les produits dans la modal
function showProducts(articles) {
  modalBody.innerHTML = articles.map(article => `
    <div class="mb-3">
      <img src="${article.image || 'placeholder.jpg'}" alt="${article.nom}" class="img-thumbnail" width="100">
      <p><strong>${article.nom}</strong> - ${article.prix} DA</p>
    </div>
  `).join('');
}

// Confirmer une commande
function confirmOrder(order, row) {
  const confirmedRow = createRow(order, false);
  confirmedTable.appendChild(confirmedRow);
  row.remove();
}

// Annuler une commande
function cancelOrder(row) {
  row.remove();
}

// Définir la date actuelle
document.getElementById('current-date').textContent = new Date().toLocaleDateString('fr-FR');